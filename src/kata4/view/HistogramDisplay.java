package kata4.view;

import kata4.model.Histogram;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


public class HistogramDisplay extends ApplicationFrame{
    
    private Histogram histogram;
    
    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
        
    }

    public void execute() {
        setVisible(true);
    }
    private JPanel createPanel() {
        ChartPanel chartpanel = new ChartPanel(createChart(createDataSet()));
        chartpanel.setPreferredSize(new Dimension(500,400));
        return chartpanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataSet) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", //Titulo
                                                        "Dominios emails", //Eje x
                                                        "Nº de emails", //Eje y
                                                        dataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false, // Leyenda
                                                        false,
                                                        rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        /*
        dataSet.addValue(300,"ULPGC","ulpgc.es");
        dataSet.addValue(500,"GOOGLE","google.es");
        dataSet.addValue(100,"HOTMAIL","hotmail.es");*/
        
        for (Object key : this.histogram.keySet()) {
            dataSet.addValue(this.histogram.get(key),"",key.toString());
        }
        
        
        return dataSet;
    }
}
