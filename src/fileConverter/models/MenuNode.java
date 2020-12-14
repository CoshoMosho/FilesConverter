package fileConverter.models;

import java.util.ArrayList;

public class MenuNode {
	private int nodeId;
	private String nodeName;
	private String nodeType;
	private String groupType;
	private String flowType;
	private String status;
	private long startValidityTs;
	private long endValidityTs;
	private String tag;
	private Resource resource;
	private ArrayList<MenuNode> nodes;

	public int getNodeId() {
		return nodeId;
	}

	public String getNodeName() {
		return nodeName;
	}

	public String getNodeType() {
		return nodeType;
	}

	public String getGroupType() {
		return groupType;
	}

	public String getFlowType() {
		return flowType;
	}

	public String getStatus() {
		return status;
	}

	public long getStartValidityTs() {
		return startValidityTs;
	}

	public long getEndValidityTs() {
		return endValidityTs;
	}

	public String getTag() {
		return tag;
	}

	public Resource getResource() {
		return resource;
	}

	public ArrayList<MenuNode> getNodes() {
		return nodes;
	}

	public void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	public void setFlowType(String flowType) {
		this.flowType = flowType;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStartValidityTs(long startValidityTs) {
		this.startValidityTs = startValidityTs;
	}

	public void setEndValidityTs(long endValidityTs) {
		this.endValidityTs = endValidityTs;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public void setNodes(ArrayList<MenuNode> nodes) {
		this.nodes = nodes;
	}

	@Override
	public String toString() {
		return "MenuNode [nodeId=" + nodeId + ", nodeName=" + nodeName + ", nodeType=" + nodeType + ", groupType="
				+ groupType + ", flowType=" + flowType + ", status=" + status + ", startValidityTs=" + startValidityTs
				+ ", endValidityTs=" + endValidityTs + ", tag=" + tag + ", resource=" + resource + ", nodes=" + nodes
				+ "]";
	}

}
