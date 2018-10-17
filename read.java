import java.io.*;
public class read {
	public static void main(String[] args)throws IOException
	{
		int line=0;
		String content="";
		try{
			BufferedReader in = new BufferedReader(new FileReader("E:\\portfolio.html"));
	        String str;
	        while ((str = in.readLine()) != null) {
	            content +=str+"\n";
	            line++;
	        }
	        in.close();
	        System.out.println(content);
	        
		}
		catch(FileNotFoundException e){
			System.out.println("file not found");
			
		}int k=0,i=0;
		String arr[]=new String[line];  //storing each line separately
		while(i<line)
		{
			for(int j=0;j<content.length();j++)
			{
			if(content.charAt(j)=='\n')
			{
			arr[i]=content.substring(k,j);
			i++;
			k=j+1;
			}}
		}
		String tagname="",subsent="",closetag="",subsentclose="";content=content+" ";
		int ind,index;
		for(int lineno=0;lineno<line;lineno++)
		{
			for(int letter=0;letter<arr[lineno].length()-1;letter++)
			{
				tagname="";subsent="";
				if(arr[lineno].charAt(letter)=='<' && arr[lineno].charAt(letter+1)!='/' && arr[lineno].charAt(letter+1)!='!')
				{
					subsent=arr[lineno].substring(letter+1);
					ind=subsent.indexOf('>');
					tagname=subsent.substring(0,ind);
					tagname=tagname+" ";
					tagname=tagname.substring(0,tagname.indexOf(' '));
				    if(tagname!="br" && tagname!="area" && tagname!="base" && tagname!="col" && tagname!="command" && tagname!="embed" && tagname!="hr" && tagname!="img" && tagname!="input" && tagname!="keygen" && tagname!="meta" && tagname!="link" && tagname!="menuitem" && tagname!="param" && tagname!="source" && tagname!="track" && tagname!="wbr")
				    {
				    for(int e=0;e<(content.length()-2);e++)
				    {
				    	if(content.charAt(e)=='<' && content.charAt(e+1)=='/')
				    	{
				    		closetag=content.substring(e+2);
				    		index=closetag.indexOf('>');
				    		subsentclose=closetag.substring(0,index);
				    		if(subsentclose.equals(tagname))
				    		{
				    			break;
				    		}
				    	}
				    	if(e==content.length()-3)
				    	{
				    		System.out.println(tagname+" tag not closed in line "+(lineno+1));
				    	}
				    }
				    }
		    	}
				}
	    }
     }
}
