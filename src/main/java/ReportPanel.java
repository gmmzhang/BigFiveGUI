import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ReportPanel extends JPanel {
    private static ArrayList<Double> finalWeights;
    private MainFrame frame;
    private String userID;
    private int[] questionAnswer;
    private JButton commentsButton;

    public ReportPanel(MainFrame mainframe, String user, int[] answer) {
        frame = mainframe;
        userID = user;
        questionAnswer = answer;
        finalWeights = new ArrayList<Double>();

        //System.out.println(Arrays.toString(questionAnswer));
        //System.out.println(Arrays.toString(reverse(questionAnswer)));
        int[] answerArray = reverse(questionAnswer);
        //System.out.println(Arrays.toString(answerArray));

        finalWeights.add(getAvgE(reverse(questionAnswer)));
        finalWeights.add(getAvgA(reverse(questionAnswer)));
        finalWeights.add(getAvgC(reverse(questionAnswer)));
        finalWeights.add(getAvgN(reverse(questionAnswer)));
        finalWeights.add(getAvgI(reverse(questionAnswer)));

        System.out.println(finalWeights);

        add(createDemoPanel());

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));

        commentsButton = new JButton("Leave Feedback");
        commentsButton.addActionListener(new CommentsButtonListener());
        add(commentsButton, BorderLayout.SOUTH);

    }

    public int[] reverse(int[] arr1){
        int[] arr2 = new int[20];
        arr2[0] = arr1[0];
        arr2[1] = arr1[1];
        arr2[2] = arr1[2];
        arr2[3] = arr1[3];
        arr2[4] = arr1[4];
        arr2[5] = 6- arr1[5];
        arr2[6] = 6- arr1[6];
        arr2[7] = 6- arr1[7];
        arr2[8] = 6- arr1[8];
        arr2[9] = 6- arr1[9];
        arr2[10] = arr1[10];
        arr2[11] = arr1[11];
        arr2[12] = arr1[12];
        arr2[13] = arr1[13];
        arr2[14] = 6- arr1[14];
        arr2[15] = 6- arr1[15];
        arr2[16] = 6- arr1[16];
        arr2[17] = 6- arr1[17];
        arr2[18] = 6- arr1[18];
        arr2[19] = 6- arr1[19];
        return arr2;
    }

    int sumE;
    double avgE;
    int sumA;
    double avgA;
    int sumC;
    double avgC;
    int sumN;
    double avgN;
    int sumI;
    double avgI;

    public double getAvgE (int[] arr) {
        for(int i=0; i<20; i+=5){
            sumE += arr[i];
            avgE = sumE/4.0;
        }
        return avgE;
    }

    public double getAvgA (int[] arr) {
        for(int i=1; i<20; i+=5){
            sumA += arr[i];
            avgA = sumA/4.0;
        }
        return avgA;
    }

    public double getAvgC (int[] arr) {
        for(int i=2; i<20; i+=5){
            sumC += arr[i];
            avgC = sumC/4.0;
        }
        return avgC;
    }

    public double getAvgN (int[] arr) {
        for(int i=3; i<20; i+=5){
            sumN += arr[i];
            avgN = sumN/4.0;
        }
        return avgN;
    }

    public double getAvgI (int[] arr) {
        for(int i=4; i<20; i+=5){
            sumI += arr[i];
            avgI = sumI/4.0;
        }
        return avgI;
    }

    private static PieDataset createDataset(ArrayList<Double> arr){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Extraversion", arr.get(0));
        dataset.setValue("Agreeableness", arr.get(1));
        dataset.setValue("Conscientiousness", arr.get(2));
        dataset.setValue("Neuroticism", arr.get(3));
        dataset.setValue("Intellect/Imagination", arr.get(4));
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset){
        JFreeChart chart = ChartFactory.createPieChart(
                "Big Five Personality",
                dataset,
                true,
                true,
                false
        );
        return chart;
    }

//    PiePlot plot = (PiePlot) createChart(createDataset(finalWeights)).getPlot();
//    plot.setLabelGenerator(true);

    public static JPanel createDemoPanel(){
        JFreeChart chart = createChart(createDataset(finalWeights));

        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}:  {2}", new DecimalFormat("0"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);

        return new ChartPanel(chart);
    }

    private class CommentsButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            frame.leaveComments(userID);
        }
    }



}