package edu.umb.cs.cs680.hw11;

import java.util.ArrayList;
import java.util.Comparator;

public class Shell {
	// To add mv and scp
	FileSystem fs;

	public Shell(FileSystem fs){
		this.fs = fs;
		this.fs.setCurrent(this.fs.root);
	}

	public void execute(String command) {
		FileSystem fs = FileSystem.getInstance();
		History history = History.getInstance();
		boolean flag = true;
		while(flag) {
			String str = command.substring(0, command.indexOf(" ")); 
			switch (str) {
				case "cd" : {
					String path = command.substring(command.indexOf(" ")+1,command.length());
					Cd cd = new Cd(this.fs, path);
					cd.execute();
					history.add(cd, command);
					flag = false;
					break;
				}
				case "pwd": {
					Pwd pwd = new Pwd(this.fs);
					pwd.execute();
					history.add(pwd, str);
					flag = false;
					break;
				}
				case "ls": {
					Ls ls = new Ls(this.fs);
					ls.execute();
					history.add(ls, command);
					flag = false;
					break;
				}
				case "dir": {
					String path = command.substring(command.indexOf(" ")+1,command.length());
					Dir dir = new Dir(this.fs);
					dir.path = path;
					dir.execute();
					history.add(dir, command);
					flag = false;
					break;
				}
				case "mkdir": {
					String path = command.substring(command.indexOf(" ")+1,command.length()); 
					Mkdir mkdir = new Mkdir(this.fs,path);
					mkdir.execute();
					history.add(mkdir, command);
					flag = false;
					break;
				}
				case "rmdir": {
					String path = command.substring(command.indexOf(" ")+1,command.length());
					Rmdir rmdir = new Rmdir(this.fs,path);
					rmdir.execute();
					history.add(rmdir, command);
					flag = false;
					break;
				}
				case "cp": {
					ArrayList <String> strList = new ArrayList<String>();
					char arr[] = command.toCharArray();
					int i=0;
					while(i<arr.length) {
						if(arr[i] == ' '){
							i++;
							StringBuffer pathToAdd = new StringBuffer();
							while(i<arr.length && arr[i] != ' ') {
								pathToAdd.append(arr[i]);
								i++;
							}
							if(pathToAdd.toString() != ""){
								strList.add(pathToAdd.toString());
							}
							
						}else{
							i++;
						}
						if(i>arr.length)
							break;
					}
					//System.out.println(strList.get(0));
					Cp cp = new Cp(this.fs,strList.get(0), strList.get(1));
					cp.execute();
					history.add(cp, command);
					flag = false;
					break;
				}
				case "mv": {
					ArrayList <String> strList = new ArrayList<String>();
					char arr[] = command.toCharArray();
					int i=0;
					while(i<arr.length) {
						if(arr[i] == ' '){
							i++;
							StringBuffer pathToAdd = new StringBuffer();
							while(i<arr.length && arr[i] != ' ') {
								pathToAdd.append(arr[i]);
								i++;
							}
							if(pathToAdd.toString() != ""){
								strList.add(pathToAdd.toString());
							}
							
						}else{
							i++;
						}
						if(i>arr.length)
							break;
					}
					//System.out.println(strList.get(0));
					Mv mv = new Mv(this.fs,strList.get(0), strList.get(1));
					mv.execute();
					history.add(mv, command);
					flag = false;
					break;
				}
				case "ln": {
					ArrayList <String> strList = new ArrayList<String>();
					char arr[] = command.toCharArray();
					int i=0;
					while(i<arr.length) {
						if(arr[i] == ' '){
							i++;
							StringBuffer pathToAdd = new StringBuffer();
							while(i<arr.length && arr[i] != ' ') {
								pathToAdd.append(arr[i]);
								i++;
							}
							if(pathToAdd.toString() != ""){
								strList.add(pathToAdd.toString());
							}
							
						}else{
							i++;
						}
						if(i>arr.length)
							break;
					}
					Ln ln = new Ln(this.fs,strList.get(0),strList.get(1),strList.get(2));
					ln.execute();
					history.add(ln, command);
					flag = false;
					break;
				}
				case "history": {
					history.execute();
					history.add(history, command);
					flag = false;
					break;
				}
				case "redo": {
					Redo redo= new Redo(history);
					redo.execute();
					history.add(redo, command);
					flag = false;
					break;
				}
				case "sort": {
					Comparator comparator =new AlphabeticalComparator();
					
					switch(command.substring(command.indexOf(" ")+1,command.length())){
						case "-a":
						{
							comparator = new AlphabeticalComparator();
							break;
						}
						case "-r":
						{
							comparator = new ReverseAlphabeticalComparator();
							break;
						}
						case "-t":
						{
							comparator = new TimeStampComparator();
							break;
						}
						default:
						{
							comparator = new AlphabeticalComparator();
							break;
						}					
					}
					Sort sort = new Sort(this.fs,comparator);
					sort.execute();
					history.add(sort, command);
					flag = false;
					break;
				}
				case "chown": {
					ArrayList <String> strList = new ArrayList<String>();
					char arr[] = command.toCharArray();
					int i=0;
					while(i<arr.length) {
						if(arr[i] == ' '){
							i++;
							StringBuffer pathToAdd = new StringBuffer();
							while(i<arr.length && arr[i] != ' ') {
								pathToAdd.append(arr[i]);
								i++;
							}
							if(pathToAdd.toString() != ""){
								strList.add(pathToAdd.toString());
							}
							
						}else{
							i++;
						}
						if(i>arr.length)
							break;
					}
					System.out.println(strList.get(0));
					Chown chown = new Chown(this.fs,strList.get(0), strList.get(1));
					chown.execute();
					history.add(chown, command);
					flag = false;
					break;
				}

				default: {
					break;
				}
			
			}
		}
	}
}
