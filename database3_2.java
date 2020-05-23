import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;

public class database3_2 {

    public static void main(String[] args) {
    	Dimension viewArea = new Dimension(800, 600);
        Graph<MyNode,MyEdge> graph = new DirectedSparseGraph<MyNode,MyEdge>();
        MyNode Root = new MyNode("Root");
        MyNode n2 = new MyNode("");
        MyNode n3 = new MyNode("");
        MyNode n4 = new MyNode("");
        MyNode Mark = new MyNode("MarkHamill");
        MyNode Oak = new MyNode("Oak");
        MyNode Bwood = new MyNode("B'wood");
        MyNode sw = new MyNode("Star Wars");
        MyNode y = new MyNode("1977");
        MyNode CF = new MyNode("CarneFisher");
        MyNode n5 = new MyNode("");
        MyNode n6 = new MyNode("");
        MyNode M = new MyNode("Maple");
        MyNode H = new MyNode("H'wood");
        MyNode L = new MyNode("Locust");
        MyNode Ma = new MyNode("Malibu");
        MyNode GL = new MyNode("George Lucas");
        MyNode GK = new MyNode("Gary Kurtz");
        MyNode ESB = new MyNode("Empire Strike Back");
        MyNode Rotj = new MyNode("Return of the jedi");
        graph.addVertex(Root);
        graph.addVertex(n2);
        graph.addVertex(n3);
        graph.addVertex(n4);
        graph.addVertex(Mark);
        graph.addVertex(Oak);
        graph.addVertex(Bwood);
        graph.addVertex(sw);
        graph.addVertex(y);
        graph.addVertex(CF);
        graph.addVertex(n5);
        graph.addVertex(n6);
        graph.addVertex(H);
        graph.addVertex(M);
        graph.addVertex(L);
        graph.addVertex(Ma);
        graph.addVertex(GL);
        graph.addVertex(GK);
        graph.addVertex(ESB);
        graph.addVertex(Rotj);
        graph.addEdge(new MyEdge("star"), Root, n2);
        graph.addEdge(new MyEdge("Movie"), Root, n3);
        graph.addEdge(new MyEdge("star"), Root, n4);
        graph.addEdge(new MyEdge("name"), n4, Mark);
        graph.addEdge(new MyEdge("street"), n4, Oak);
        graph.addEdge(new MyEdge("city"), n4, Bwood);
        graph.addEdge(new MyEdge("title"), n3, sw);
        graph.addEdge(new MyEdge("year"), n3, y);
        graph.addEdge(new MyEdge("starsIn"), n4, n3);
        graph.addEdge(new MyEdge("starOf"), n3, n4);
        graph.addEdge(new MyEdge("starsIn"), n2, n3);
        graph.addEdge(new MyEdge("starOf"), n3, n2);
        graph.addEdge(new MyEdge("name"), n2, CF);
        graph.addEdge(new MyEdge("address"), n2, n5);
        graph.addEdge(new MyEdge("address"), n2, n6);
        graph.addEdge(new MyEdge("street"), n5, M);
        graph.addEdge(new MyEdge("city"), n5, H);
        graph.addEdge(new MyEdge("street"), n6, L);
        graph.addEdge(new MyEdge("city"), n6, Ma);
        graph.addEdge(new MyEdge("ディレクター"), sw, GL);
        graph.addEdge(new MyEdge("プロデューサー"), sw, GK);
        graph.addEdge(new MyEdge("出演"), Mark, ESB);
        graph.addEdge(new MyEdge("出演"), Mark, Rotj);
        graph.addEdge(new MyEdge("出演"), CF, ESB);
        graph.addEdge(new MyEdge("出演"), CF, Rotj);
        
        Layout<MyNode,MyEdge> layout = new FRLayout<MyNode,MyEdge>(graph,viewArea);

        
        
        BasicVisualizationServer<MyNode,MyEdge> panel = new BasicVisualizationServer<MyNode,MyEdge>(layout, viewArea);
        panel.getRenderContext().setVertexLabelTransformer(new ToStringLabeller<MyNode>());
        panel.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller<MyEdge>());
        JFrame frame = new JFrame("Graph View: Directed Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

}