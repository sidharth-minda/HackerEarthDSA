import java.util.*;
public class Loop_in_a_Linked_List {
	static Node head=null;
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			next=null;
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		Node last=null;
		for(int i=0;i<n;i++)
		{
			Node newNode=new Node(sc.nextInt());
			if(head==null)
				head=newNode;
			else
				last.next=newNode;
			last=newNode;
		}
		last.next=head;
		detect_Loop();
		
	}
	
	public static void detect_Loop()
	{
		Node slow=head;
		Node fast=head;
		int flag=0;
		while(slow!=fast || slow!=null || fast!=null)
		{
			if(slow==fast)
				flag=1;
			slow=slow.next;
			fast=fast.next.next;
		}
		if(flag==0)
			System.out.println("No loop present");
		else
			System.out.println("Loop present");
	}
}
