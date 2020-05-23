import java.awt.Dimension;

import javax.swing.JFrame;

import edu.uci.ics.jung.algorithms.layout.FRLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.UndirectedSparseGraph;
import edu.uci.ics.jung.graph.util.Pair;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
public class info2 {

	public static void main(String[] args) {
	  JFrame frame = new JFrame("Graph View");
	  Graph<String,String> graph
	    =new UndirectedSparseGraph<String,String>();
	  graph.addVertex("v1");//頂点を生成
	  graph.addVertex("v2");
	  graph.addVertex("v3");
	  graph.addEdge("e1","v1","v2");//v1とv2を結ぶ辺
	  graph.addEdge("e2","v2","v3");
	  Dimension viewArea = new Dimension(600,600);
	  Layout<String,String>layout =
			  new FRLayout<String,String>(graph, viewArea);
	  BasicVisualizationServer<String,String> panel=
			  new BasicVisualizationServer<String,String>(layout,viewArea);
	  frame.getContentPane().add(panel);
	  frame.pack();
	  frame.setVisible(true);
	  panel.getRenderContext().setVertexLabelTransformer
	    (new ToStringLabeller<String>());
	  panel.getRenderContext().setEdgeLabelTransformer
	    (new ToStringLabeller<String>());
	  System.out.println("Graph=" +graph.toString());
	  System.out.println(graph.toString());
	  Pair<String> pair = graph.getEndpoints("e2");
	  System.out.println("from="+pair.getFirst());
	  System.out.println("to="+pair.getSecond());
	}

}
