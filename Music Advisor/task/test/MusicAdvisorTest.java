import org.hyperskill.hstest.stage.StageTest;
import org.hyperskill.hstest.testcase.CheckResult;

import org.hyperskill.hstest.dynamic.DynamicTest;
import org.hyperskill.hstest.testing.TestedProgram;

public class MusicAdvisorTest extends StageTest {
    @DynamicTest(order = 91)
    CheckResult musicAdvisorTestExit() {
        TestedProgram main = new TestedProgram();
        main.start();

        // Test for "exit"
        String actualPrompt5Output = main.execute("exit").trim();
        delay1Second();

        if (!actualPrompt5Output.toLowerCase().contains("goodbye") || !main.isFinished()) {
            return CheckResult.wrong("After receiving the \"exit\" command, your program should output '---GOODBYE!---', and then terminate.");
        }

        return CheckResult.correct();
    }

    @DynamicTest(order = 101)
    CheckResult musicAdvisorTestNewExit() {
        TestedProgram main = new TestedProgram();
        main.start();

        // Test for "new"
        String actualPrompt2Output = main.execute("new").trim();
        String[] actualPrompt2OutputLines = actualPrompt2Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt2OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using \"new\" as input, expected the output to contain '---NEW RELEASES---' in the first line, followed by a list of new albums on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt2OutputLines[0].toLowerCase().contains("new releases")) {
            return CheckResult.wrong("When using \"new\" as input, expected the output to contain '---NEW RELEASES---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt2OutputLines.length < 2) {
            return CheckResult.wrong("When using \"new\" as input, expected to see a list of new albums on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        // TODO (in stage descriptions): Because "exit" should be independent of "auth". Program should exit, regardless of successful "auth".
        main.execute("exit");

        return CheckResult.correct();
    }

    @DynamicTest(order = 102)
    CheckResult musicAdvisorTestFeaturedExit() {
        TestedProgram main = new TestedProgram();
        main.start();

        // Test for "featured"
        String actualPrompt1Output = main.execute("featured").trim();
        String[] actualPrompt1OutputLines = actualPrompt1Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt1OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using \"featured\" as input, expected the output to contain '---FEATURED---' in the first line, followed by a list of featured playlists on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt1OutputLines[0].toLowerCase().contains("featured")) {
            return CheckResult.wrong("When using \"featured\" as input, expected the output to contain '---FEATURED---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt1OutputLines.length < 2) {
            return CheckResult.wrong("When using \"featured\" as input, expected to see a list of featured playlists on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        main.execute("exit");

        return CheckResult.correct();
    }

    @DynamicTest(order = 103)
    CheckResult musicAdvisorTestFeaturedNewExit() {
        TestedProgram main = new TestedProgram();
        main.start();

        // Test for "featured"
        String actualPrompt1Output = main.execute("featured").trim();
        String[] actualPrompt1OutputLines = actualPrompt1Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt1OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using \"featured\" as input, expected the output to contain '---FEATURED---' in the first line, followed by a list of featured playlists on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt1OutputLines[0].toLowerCase().contains("featured")) {
            return CheckResult.wrong("When using \"featured\" as input, expected the output to contain '---FEATURED---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt1OutputLines.length < 2) {
            return CheckResult.wrong("When using \"featured\" as input, expected to see a list of featured playlists on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        // Test for "new"
        String actualPrompt2Output = main.execute("new").trim();
        String[] actualPrompt2OutputLines = actualPrompt2Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt2OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using \"new\" as input, expected the output to contain '---NEW RELEASES---' in the first line, followed by a list of new albums on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt2OutputLines[0].toLowerCase().contains("new releases")) {
            return CheckResult.wrong("When using \"new\" as input, expected the output to contain '---NEW RELEASES---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt2OutputLines.length < 2) {
            return CheckResult.wrong("When using \"new\" as input, expected to see a list of new albums on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        main.execute("exit");

        return CheckResult.correct();
    }

    @DynamicTest(order = 104)
    CheckResult musicAdvisorTestCategoriesExit() {
        TestedProgram main = new TestedProgram();
        main.start();

        // Test for "categories"
        String actualPrompt3Output = main.execute("categories").trim();
        String[] actualPrompt3OutputLines = actualPrompt3Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt3OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using \"categories\" as input, expected the output to contain a list of all available categories on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt3OutputLines[0].toLowerCase().contains("categories")) {
            return CheckResult.wrong("When using \"categories\" as input, expected the output to contain '---CATEGORIES---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt3OutputLines.length < 2) {
            return CheckResult.wrong("When using \"categories\" as input, expected the output to contain a list of all available categories on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        // Test for "playlists <CATEGORY>"
        String category = actualPrompt3OutputLines[1];
        String actualPrompt4Output = main.execute("playlists " + category).trim();
        String[] actualPrompt4OutputLines = actualPrompt4Output.split("\n");
        // Check if the first line is empty
        if (actualPrompt4OutputLines[0].isEmpty()) {
            return CheckResult.wrong("When using 'playlists " + category + "' as input, expected the output to contain a list of playlists of " + category + " on Spotify (use a dummy list for now). But found a blank output.");
        }
        if (!actualPrompt4OutputLines[0].toLowerCase().contains(category.toLowerCase()) || !actualPrompt4OutputLines[0].toLowerCase().contains("playlists")) {
            return CheckResult.wrong("When using 'playlists " + category + "' as input, expected the output to contain '---" + category.toUpperCase() + " PLAYLISTS---' in the first line. But it was either missing or incorrect.");
        }
        // Ensure there are additional lines
        if (actualPrompt4OutputLines.length < 2) {
            return CheckResult.wrong("When using 'playlists " + category + "' as input, expected the output to contain a list of playlists of " + category + " on Spotify (use a dummy list for now). But that actual list was missing.");
        }

        main.execute("exit");

        return CheckResult.correct();
    }

    private static void delay1Second() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

