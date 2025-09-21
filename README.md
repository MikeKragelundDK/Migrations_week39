# State-Based Migrations — Short README (for review)

> This document is a brief explanation of **what I did** and **why**—it’s not meant to be executed.

## Approach

* I keep each step’s `.sql` files in `/resources/blueprint/`.
* I use **Atlas**. I maintain **two databases**:

    * one empty database created from the newest `blueprint.sql` (my mock DB),
    * and one with the prior version (my dev/“production” stand-in).
* From those, I run an Atlas schema diff locally, which gives me a recipe for changing my production-like DB to the mock DB.
  I paste Atlas’ output into `/resources/blueprint/atlas.sql`.
* I then **run the generated SQL manually** in my SQL workspace.

## Workflow (what I do each version)

1. I make a new `blueprint.sql`.
2. I create a new mock DB from that blueprint.
3. I compare the mock DB with my production-like DB using Atlas to get a diff.
4. I paste the diff into `/resources/blueprint/atlas.sql` and run it manually.
5. I compile the code with `spring.jpa.hibernate.ddl-auto=validate` so JPA throws if entities and schema don’t match.

---

## State-Based Migration Log

**V1**
I created the database and three tables. I connected `enrollment` to `student` and `course` via their IDs.
My production-like DB was empty here, so the Atlas diff was almost identical to the blueprint.

**V2**
I added a `middle_name` attribute to both the mock database and the corresponding entity.

**V3**
I did a similar change to V2. Worth noting: Atlas preserved column order (e.g., `AFTER email`).

**(Git note)**
I messed up with Git here—this ended up as a joined commit/branch.

**V4**
I made the `instructor` table and added the keys. I put a `@OneToOne` relationship and configured null/remove on delete.
In theory, this could also be `@ManyToOne` or `@ManyToMany` depending on the domain.

**V5**
I added a new column (similar to the “adding tasks” flow), updated the entity, and updated `blueprint.sql`.

**V6**
I added `department` to the relation. I used a `@OneToOne` on `instructorId`.

**V7**
I fixed JPA exceptions around numeric mapping. I ended up using `BigDecimal`.
This isn’t ideal because `BigDecimal` is arbitrary precision, so we could overshoot a SQL `DECIMAL(5,2)` constraint.
If this were production, I’d use a value object or validation to enforce precision/scale in code, not just in the DB.

---

## Folder Notes

* `/resources/blueprint/blueprint.sql`: the desired latest state per version.
* `/resources/blueprint/atlas.sql`: the SQL diff Atlas produced for that version (which I ran manually).
