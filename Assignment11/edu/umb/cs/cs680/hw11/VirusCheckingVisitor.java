package edu.umb.cs.cs680.hw11;

public class VirusCheckingVisitor implements FSVisitor{
	
	private int quarantine = 0;
	
	@Override
	public void visit(Link link) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(Directory directory) {
		// TODO Auto-generated method stub
		return;
	}

	@Override
	public void visit(File file) {
		// TODO Auto-generated method stub
		this.quarantine++;
	}

	public int getQuarantinedNum() {
		return this.quarantine;
	}
}
