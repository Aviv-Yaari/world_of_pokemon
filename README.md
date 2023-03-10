![Pokemon Logo](https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/International_Pok%C3%A9mon_logo.svg/2560px-International_Pok%C3%A9mon_logo.svg.png)

# World of Pokemon
This project demonstrates the use of Java Spring Boot Hibernate JPA, and a MySQL database. It showcases how these technologies can be used to address a specific challenge, which is the lack of a plural form for the word "Pokemon" 😂  
This might turn in the future into a monorepo with a frontend implementation as well.
___

### Endpoints
The following REST API endpoints are available in the project:
- GET **/pokemon/list**  - Lists all the Pokemon.
- GET **/trainer/list** - Lists all the trainers.
- GET **/trainer/{name}** - Finds a trainer by name.
- POST **/battle/{trainer1_name}/{trainer2_name}** - Executes a battle between two trainers. The winner levels up.
- PATCH **/trainer/{trainer_name}/pokemon/{pokemon_name}** - Adds a Pokemon to the trainer's bag.

### Entities
The project features the following entities:
- **Pokemon**:
  - id: Long.
  - name: String.
  - type: Grass/Wind/Fire.
- **Trainer**
  - id: Long.
  - name: String.
  - level: int.
- **Battle**
  - trainer1_id: trainer id.
  - trainer2_id: trainer id.
  - winner: trainer id.
  - date: Timestamp.

Relationships:
- Trainer ~ Pokemon: Many to many, each trainer can own multiple Pokemon, each Pokemon can be owned by multiple trainers.
- Battle ~ Trainer1/2: Many to one. Each trainer can fight in multiple battles. Each battle must have 2 trainers.

Note: A trainer's bag can contain up to 3 Pokemon. When a trainer tries to catch a Pokemon when the bag is full, the new Pokemon will be added in place of the oldest Pokemon in the bag.
