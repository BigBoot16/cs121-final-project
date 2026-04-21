classDiagram
    Character <|-- Culprit
    Game --o Character

    class Game{
        -victim: Character
        -culprit: Culprit
        -witnesses: Vector of character addresses
        +startGame()
        +question()
        +arrest()
    }

    class Character{
        -location: string
        -name: string
        +Character()
        +Character(location string, name string)
        +getLocation(return string)
    }

    class Culprit{
        -falseLocation: string
        -weapon: string
        -redHerring: Witness address
        +Culprit()
        +Culprit(falseLocation string, weapon string, redHerring Witness)
    }
