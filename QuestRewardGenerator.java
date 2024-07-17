public class QuestRewardGenerator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java QuestRewardGenerator <number_of_quests>");
            System.exit(1);
        }

        int count = 0;
        try {
            count = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("The argument must be an integer.");
            System.exit(1);
        }

        if (count < 0) {
            System.err.println("The argument must be a positive number.");
            System.exit(1);
        }

        String rewardString = generateQuestRewards(count);
        System.out.println(rewardString);
    }

    public static String generateQuestRewards(int N) {
        StringBuilder rewards = new StringBuilder();

        for (int i = 0; i < N; i++) {
            double probabilityOfBronze = calculateBronzeProbability(i, N);
            double pseudoRandomValue = deterministicRandom(i, N);
            if (probabilityOfBronze >= pseudoRandomValue) {
                rewards.append('b');
            } else {
                rewards.append('s');
            }
        }

        return rewards.toString();
    }

    private static double calculateBronzeProbability(int index, int total) {
        double x = (double) index / total;
        return Math.pow(1 - x, 1.2) * (1 - 0.1 * Math.sin(3 * Math.PI * x));
    }

    private static double deterministicRandom(int index, int total) {
        long value = (long) index * 6364136223846793005L + total * 1442695040888963407L;
        value = (value ^ (value >> 21)) ^ (value << 35) ^ (value >> 4);
        value = value * 2685821657736338717L;
        return (double) (value & 0xFFFFFFFFL) / 0x100000000L;
    }
}
