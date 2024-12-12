package structra.assignment.task.de.rub.client;

import structra.assignment.framework.llm.MachineLearningModel;
import structra.assignment.framework.llm.gen.questions.OpenQuestionTarget;
import structra.assignment.framework.llm.gen.questions.QuestionGenerationTarget;
import structra.assignment.framework.llm.gen.questions.RandomTargetProvider;
import structra.assignment.framework.llm.gen.questions.TargetProvider;
import structra.assignment.framework.llm.model.Mimic;
import structra.assignment.framework.model.question.base.Question;
import structra.assignment.framework.provide.ModelQuestionProvider;
import structra.assignment.framework.provide.QuestionProvider;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

public class GUI {

    public static Question<?> Question() {

        // Create a new KeyProvider to provide the API key
        KeyProviderChatGPT keyProvider = new KeyProviderChatGPT(); // Done in Task 1

        // Pass your Plugin to the Model you want to use
        MachineLearningModel mimic = new Mimic(keyProvider);

    /*
     Create a new RandomTargetProvider with the given QuestionTargets.
     In this case Mimic will always return multiple choice questions, since setting the prompt to Mimic.MULTIPLE_CHOICE
     will let Mimic always return multiple choice questions.
    */
        TargetProvider provider = new RandomTargetProvider(new OpenQuestionTarget(Mimic.OPEN_ANSWER));


        // Creates a new QuestionProvider with the model, provider and an empty list of questions, since
        // we do not want to pass any additional questions as context to the model.
        QuestionProvider questionProvider = new ModelQuestionProvider(mimic, provider, new ArrayList<>());

        // Create a new CompletableFuture object, holding the question, once generation has finished
        CompletableFuture<Question<?>> future = questionProvider.next();

        // Create a new CompletableFuture object
        //CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> questionProvider.next().toString());

        // Use join() to block and get the result once it is available
        Question<?> result = future.join();

        return future.join();


    }      // erstellt alle nötigen Objekte und gibt das Objekt Question zurück




    private static void createAndShowGUI() {

        // Create and set up the window
        JFrame frame = new JFrame("GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Add the "Hello World" label to the center of the window
        JLabel label = new JLabel(Question().getText(), SwingConstants.CENTER);    // Textfeld, welches die erste Frage enthält
        JButton button1 = new JButton("Next Question");

        button1.setSize(200,40);
        button1.setLocation(20,260);

        label.setLocation(SwingConstants.LEFT,SwingConstants.TOP);
        label.setSize(800,250);
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setVerticalAlignment(SwingConstants.TOP);

        Border border = BorderFactory.createLineBorder(Color.BLACK, 2); //Rahmen um Bereich von Label sichtbar zu machen
        label.setBorder(border);

        frame.add(button1);
        frame.getContentPane().add(label);




        button1.addActionListener(new ActionListener() {          //Eventhandler für den Button Click -> erneuert die Frage im Label
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(Question().getText());
            }
        });


        // Adjust position of the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        int frameWidth = (int) (width / 2);
        int frameHeight = (int) (height / 4);
        frame.setLocation((int) (width - frameWidth) / 2, (int) (height - frameHeight) / 2);
        frame.setSize(frameWidth, frameHeight);

        // Display the window
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(structra.assignment.task.de.rub.client.GUI::createAndShowGUI);

    }
}

