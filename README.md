# TwitterBot

In this assignment, you will learn how to read tweets from CSV files into a program, build your own machine learning model, and create an AI that generates (somewhat) realistic tweets!

+ FileLineIterator.java - This class is a wrapper around the Java I/O class BufferedReader that provides a simple way to work with file data line-by-line. By writing this class, you are creating a simple, nifty file reading utility for yourself.

+ *TweetParser.java - This class reads in tweet data from a file, and then cleans, filters and formats the data to improve the quality of the training data. Its interface also makes it easy for you to add that cleaned data to the Markov Chain.

+ *MarkovChain.java - This is the class to implement, well, the Markov Chain, which will count all the times that certain words follow other words in the training data. In addition to storing that data, it implements Iterator, and does so to provide a convenient way to continuously pick successive random elements,

+ *TwitterBot.java - This is the class where you put everything together. Here, you will use TweetParser to clean and parse tweet data, write logic for adding that data to an instance of MarkovChain, and then use the populated MarkovChain to generate tweets.

+ ProbabilityDistribution.java - This class is useful for counting occurrences of things. You will use it in building MarkovChain. It contains a Map<T, Integer>, where the keys are instances of objects of type T and the Integer represents the count for the number of times that object occurred. It also provides a convenient way to randomly pick one of its keys.

+ NumberGenerator.java - This is an interface for any class that can generate numbers. It is used in ProbabilityDistribution for picking keys.

+ RandomNumberGenerator.java - This class implements NumberGenerator and just generates numbers randomly.

+ ListNumberGenerator.java - This class implements NumberGenerator and also just generates numbers. Instead of being random, though, it takes a list of numbers as an input, so the user has control over what numbers it outputs. It’s useful to swap this in place of a RandomNumberGenerator when you need to eliminate randomness in order to test your MarkovChain.
