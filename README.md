Note* For each step i will have my .sql files in the /resources/blueprint folder.
I choose to use atlas as my tool.
I have two databases, one that's empty, with the newest "blueprint.sql" version, and one with the prior version. 
This is suppoosed to represent a mock database and my dev database. 
From those i run the command "atlas schema diff" which generates a file/recipe on how to change my production db to the mock db. 
I will paste in the code atlas gave me /resources/blueprint/atlas.sql. 
The code atlas gave me, i will manually run, in my SQL workspace. 

So my workflow will be like this: 

Make a new blueprint.sql file, and make a new mock db from that. 
Compare the mock db with my production db. 
Get a file from atlas and run that on my production db. 
I hope this flow makes sense. 

After each version i will compile my code, it has the tag:
spring.jpa.hibernate.ddl-auto=validate

If the entities don't match the database schema, jpa will throw an exception. 

This is my state-based migration:

V1: 
In this step i create the database - i make the 3 tables and connect enrollment to student and course, on their id's. 
My "production" database will be empty for this step, so the "schema diff" from atlas will be very similar to my blueprint. 

V2: 
In this step i add a middle_name attribute to both my mock database and the entity. 

V3:
Very similar to version 2 - worth noting is that atlas also cares for insertion order - "AFTER email"

V4: 
I made the instructor table, and added the keys. 
I put a onetoone relationship between them, where i set null/remove when deleted
In theory it could also be a manytoone, or manytomany relation.. 

V5: 
Similar to the adding tasks, changed the entity and wrote a new column on the blueprint.sql file. 

