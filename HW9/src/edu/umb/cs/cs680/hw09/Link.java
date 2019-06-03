package edu.umb.cs.cs680.hw09;

public class Link extends FSElement 
{
	FSElement ref;
	public FSElement getRef() {
		return ref;
	}


	public Link(Directory parent, String name, String owner, FSElement ref) 
	{
		
		super(parent, name, owner,0);
		this.ref = ref;
		
	}
	public int getTargetSize()
	{
		int ref1=0;
		FSElement fs = this;
		while(fs instanceof Link){
			Link fsLink = (Link) fs;
			ref1++;
			fs= fsLink.ref;
		}
		System.out.println(this.getName()+ this.getOwner()+"  TargetSize: "+ref1+"\n");
		return ref1;
	}
}
