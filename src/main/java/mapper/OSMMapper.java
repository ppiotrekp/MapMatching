package mapper;

import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.container.v0_6.NodeContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Node;
import org.openstreetmap.osmosis.core.domain.v0_6.Tag;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;
import utils.OSMNode;

import java.util.HashMap;
import java.util.Map;

public class OSMMapper implements Sink {
    @Override
    public void process(EntityContainer entityContainer) {
        if (entityContainer instanceof NodeContainer) {
            Node node = ((NodeContainer) entityContainer).getEntity();
            OSMNode osmNode = mapToOsmNode(node);
        }
    }

    private OSMNode mapToOsmNode(Node node) {
        OSMNode osmNode = new OSMNode();
        osmNode.setId(node.getId());
        osmNode.setLatitude(node.getLatitude());
        osmNode.setLongitude(node.getLongitude());

        Map<String, String> tags = new HashMap<>();
        for (Tag tag : node.getTags()) {
            tags.put(tag.getKey(), tag.getValue());
        }
        osmNode.setTags(tags);

        return osmNode;
    }

    @Override
    public void initialize(Map<String, Object> map) {

    }

    @Override
    public void complete() {

    }

    @Override
    public void close() {

    }
}
