# Change-Based Migrations with Flyway

## Approach

* I chose **Flyway** as my change-based migration framework.
* My migration files live in: `resources/db/migration/`
* I start the application; **Flyway** applies the pending migration scripts to the database.

### Notes on reverts

Reverting a bad migration was **hard**. Once a file is applied, you can’t trivially “unapply” it without writing a corrective migration. During the assignment, that meant I sometimes had to clean up the DB and Flyway metadata to move forward. In a real setup, this would be less of an issue because migrations are reviewed and tested before release—but it still taught me to be careful and to fix forward.

### Comparison to state-based

Overall, setting up Flyway felt **easier** than the state-based flow, but **writing** the migrations themselves was **harder**.

---

## Breakdown (what I did in each version)

**V1**
I initialized the database. As far as I can tell, Flyway doesn’t create the **schema/database** itself, so I created the database manually in MySQL Workbench. After that, everything ran via Flyway.

**V2**
I added a column with an `ALTER TABLE` and updated the corresponding entity.

**V3**
Same idea as V2, but this time I added a **date** column.

**V4**
I added the `instructor`. Doing the constraint **after** the table existed felt awkward—I’m used to defining constraints alongside the table definition.

**V5**
No special comments—straightforward change.

**V6**
I added `department`. This was easier than `instructor` because I wrote the constraint **within** the table definition.
I also added **V6.1** as a patch because JPA complained about **decimal** and **date** types. Initially, I wanted to revert by dropping `department` and recreating it, but the foreign key to `instructor` made that non-trivial. I ended up writing a dedicated **bugfix/patch** migration. This highlights both the **strengths** (clear history) and **weaknesses** (revert pain) of change-based migrations.

**V7**
I struggled again with JPA vs. DB data types (especially decimals). Given the tight scope of the decimal, the “optimal” solution would be a **value object** to validate/sanitize inputs and keep the logic in code rather than relying purely on database constraints.