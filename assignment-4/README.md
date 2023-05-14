0. Body Attributes

The following attributes apply to planets and moons:

    Radius: minimum of 1000 and maximum of 100000
    Orbital radius: for planets, minimum of 10000 and maximum of 2500000; for moons minimum of 7000 and maximum of 400000
    The Sun has infinite radius.

Solar System Registry

This program allows users to manipulate a registry of solar systems, stars, planets, and moons. The registry is stored in a file called solarsystems.data.
Main Menu

The program presents the following options to the user:

    1 SELECT SOLAR SYSTEM
    2 ADD BODY
    3 REMOVE BODY
    4 LIST SYSTEMS
    5 SORT BY SIZE
    6 SORT BY ORBITAL SIZE
    7 QUIT AND SAVE

    Option 1: Select a solar system from the registry
    Option 2: Add a new body (star, planet, or moon) to the selected solar system
    Option 3: Remove a body from the selected solar system
    Option 4: List all the solar systems in the registry
    Option 5: Sort the bodies in the selected solar system by size (radius)
    Option 6: Sort the bodies in the selected solar system by orbital size (orbit radius)
    Option 7: Quit the program and save the changes to the registry file

1. Solar System Selection

After selecting option 1 from the main menu, the program displays the list of available solar systems:

    0. Sun:20000

    1. Ariel:30000
    Please select:

    The user can select a solar system or return to the main menu.

2. Adding a Body

After selecting option 2 from the main menu, the program prompts the user to enter the name, radius, and orbital radius of the new body (for Sun only name and radius):

    Enter star name:
    Enter star radius:

    If the user is adding a planet or a moon, the program also asks for the name of the parent planet:

    Select (planet or moon) or 0 to return to solar system:

3. Removing a Body

After selecting option 3 from the main menu, the program presents the following options:

    Remove the entire solar system
    Remove a specific planet
    Remove a specific moon

4. Printing the system, by size and by orbital size

    After selecting option 4, 5 or 6 from the main menu, the program presents the following options:

    4. Listing all the systems in registry file.
    5. Listing all the system and sorted by the size.
    6. Listing all the systems and sorted by the orbtial size.

5. The FileHandling class handles the reading and writing of the registry file:

    FileHandling registry = new FileHandling("solarsystems.data");