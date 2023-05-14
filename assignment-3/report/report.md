# Reflection on my Intended Design
Follow the instructions and write the report in this file.

# Are there any classes missing in your design, why/why not?
There are few classes that were missed in my design, the subclass of "PlayerBehaviour" and "DiceThrow". I excluded these because I thought that throwing dices would be enough printing the results and move around, but I forgot to make a method for Player/AI to actually move. As for other class, I thought having everything in subclass "Player" would be enough and it would not make a big difference. But now I realize that everything that somehow related to other classes should be in individual subclass.

# Did you have any extra classes in your design, why/why not?
I did not add extra classes in my designs, because the whole monopoly game is quite vast, it has lots of rules, objects, events, etc. That is why I chose to make it simple without making extra mistakes due to not knowing the game itself very well myself. For example, I could have added subclass "Events" or "Jail". Plus every monopoly game has its own addons.

# Are there differences in naming the classes? How should classes be named?
I have not noticed anything in the names. The names are well structured, fit well and it is easy to understand what is what. For example, class "ConsoleUi" should be "ConsoleUI", but because of the checkstyle it has to be this way, not a big difference.

# Are there differences in the relations between the classes?
I'm not sure, but Player and Dice should have had a direct association  relation, which I missed in my design. The player and Tile also should have had an association, because player is on the Board and in order to get the tile where player is standing, needs association.

# Did you connect the objects using dependency/association or did you use id-connections?
Dependency/association relations are used in my design diagram to connect the objects based on the relation they have, if the existence of a class affects the other classes which connect to, it is used a dependency relation otherwise association. #

# Did you manage to divide the complexity/behaviour into different classes or do you have one central class having most of the code?
I did manage to divide the complexity/behaviour into different classes that have similar parameters and methods.

# What differences are there for the object diagram?
Object diagram has somewhat everything that is in sequence diagram and class diagram but it missed Tile also misses some of the attributes, such as "PlayerNum" or "ComputerNum" that generates players or computer for playing.

References:
https://youtu.be/LmIf4jPSE6Q
https://sparxsystems.com/resources/tutorials/uml2/object-diagram.html

# What differences are there for the sequence diagram?
In my sequence diagram misses attributes, such as another "Dice" to make the count up to 12 dots, "Property" I do have it in my sequence diagram but it should have also examples with street names, "ConsoleUI" is missed, "PlayerName" name of the player or computer name.

References:
https://creately.com/guides/sequence-diagram-tutorial/

# Do you think you made a good job in your initial design, why/why not?
I believe I did it decent, of course it missed a lot of aspects such as operations and attributes which had to exist in this example.

# What is the most important thing you learned by designing first?
I definetely have learnt that it requires lots of creativity, flexibility and intuition to predict what kind of operations added. And of course, it is not an easy task to make these designs, because they take a lot of time.