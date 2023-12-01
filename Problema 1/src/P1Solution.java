public class P1Solution {

    enum CHOICE {
        LOW_DEMAND_JOB,
        HIGH_DEMAND_JOB,
        NO_JOB;
    }

    private P1Solution(){}

    public static void solveP1(int l[], int h[]) {
        int[] lowDemandJob = l;
        int[] highDemandJob = h;
        int timeDuration = lowDemandJob.length;
        int currentValue;
        int currentWeek = 0;
        CHOICE choice;

        if(timeDuration <= 3) {
            System.out.println("\u001B[31mTimeframe is too short to consider the problem.\u001B[0m");
            return;
        }

        /*
            First, consider the first week (where there is no need to consider the previous week) 
        */

        // What is the best value for the first week?
        if (lowDemandJob[currentWeek] > highDemandJob[currentWeek]) {
            currentValue = lowDemandJob[currentWeek];
            choice = CHOICE.LOW_DEMAND_JOB;
        } else {
            currentValue = highDemandJob[currentWeek];
            choice = CHOICE.HIGH_DEMAND_JOB;
        }
        // Is the value still worth it when considering next weeks?
        if (
            (currentValue > highDemandJob[currentWeek + 1]) // Consider next week
            ||
            ((currentValue + highDemandJob[currentWeek + 2]) > highDemandJob[currentWeek + 1]) // Consider two weeks ahead
            ) {
            printChoice(choice, currentWeek); // Yes, so choose this week's choice
        } else {
            currentValue = highDemandJob[currentWeek + 1]; // No, so choose next week's high demand job
            printChoice(CHOICE.NO_JOB, currentWeek);
            currentWeek++;
            printChoice(CHOICE.HIGH_DEMAND_JOB, currentWeek);
        }


        /*
            Then, consider the all other weeks (where there is a need to consider the previous week)
        */
        while (currentWeek < (timeDuration - 3)) {
            currentWeek++;

            int thisWeekLow = lowDemandJob[currentWeek];
            int nextWeekLow = lowDemandJob[currentWeek + 1];
            int nextWeekHigh = highDemandJob[currentWeek + 1];
            int afterNextWeekHigh = highDemandJob[currentWeek + 2];

            if ( // Is the high demand job worth it
                (nextWeekHigh > (thisWeekLow + nextWeekLow)) // 
                 &&
                (nextWeekHigh > (thisWeekLow + afterNextWeekHigh))
                ) {
                choice = CHOICE.HIGH_DEMAND_JOB;
                printChoice(CHOICE.NO_JOB, currentWeek); // No job this week
                currentWeek++;
                printChoice(choice, currentWeek); // High demand job next week
                currentValue += nextWeekHigh;
            } else {
                choice = CHOICE.LOW_DEMAND_JOB;
                printChoice(choice, currentWeek); // Low demand job this week
                currentValue += thisWeekLow;
            }
        }

        /*
            Then, consider the second last and last weeks
        */
        // If the last week's choice was a low demand job, then working on a low demand job this week is best 
        if (choice == CHOICE.LOW_DEMAND_JOB) { // adjust timeframe
            currentWeek++;
        }
        if (highDemandJob[currentWeek + 1] > (lowDemandJob[currentWeek] + lowDemandJob[currentWeek + 1])) {
            choice = CHOICE.HIGH_DEMAND_JOB;
            printChoice(CHOICE.NO_JOB, currentWeek); // No job this week
            currentWeek++;
            printChoice(choice, currentWeek); // High demand job next week
            currentValue += highDemandJob[currentWeek];
        } else {
            choice = CHOICE.LOW_DEMAND_JOB;
            printChoice(choice, currentWeek); // Low demand job this week
            currentValue += lowDemandJob[currentWeek];
            currentWeek++;
            printChoice(choice, currentWeek); // Low demand job next week
            currentValue += lowDemandJob[currentWeek];
        }

        /*
            Finally, print the total value 
        */
        System.out.printf("\u001B[32mTotal value: %d\u001B[0m%n",currentValue);
    }

    private static void printChoice(CHOICE choice, int week) {
        StringBuilder printable = new StringBuilder("Choose"); 

        switch (choice) {
            case LOW_DEMAND_JOB:
                printable.append("\u001B[34m a low demand job\u001B[0m");
                break;
            case HIGH_DEMAND_JOB:
                printable.append( "\u001B[33m a high demand job\u001B[0m");
                break;
            default:
                printable.append("\u001B[31m no job\u001B[0m");
                break;
        }

        printable.append(" for week " + (week + 1));
        System.out.println(printable);
    }
}
