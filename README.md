# quest-reward-generator
A quest generator in Idle Outpost produces hundreds of quests per game event. Each quest can have one of two types of rewards: either a bronze chest or a silver chest, denoted as “b” and “s” respectively. The quests are sequentially ordered from the first to the last. The initial quests in the sequence have a higher probability of awarding a bronze chest, while the later quests are more likely to award a silver chest. This distribution is represented as a string of letters and mimics a given pattern.


## Implementation
The approach involves using a deterministic function to simulate pseudo-randomness and a polynomial function to gradually transition the probability of obtaining a bronze chest to a silver chest.


## Usage
Compile and run the Java program, passing the number of quests as a command line argument.
- javac QuestRewardGenerator.java
- java QuestRewardGenerator <number_of_quests>

### Input

- An integer `N`, representing the total number of quests, passed as a runtime argument.

### Output

- A string of length `N` consisting of characters "b" and "s", reflecting a similar statistical distribution as the example provided.

### Example Output
- For `N = 100`, the output might look like this `bbbbbbbbbbbbbbbbbbsbbbssbsbsbsbssbbbssbbbsbsbbsbssbbsbsssbsbsbbsssssssssbssssbsssbbsssssssssbssssbss`
