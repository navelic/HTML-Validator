import java.io.*;
public class read {

	public static void main(String[] args)throws IOException
	{
		int line=0;
		String content="";
		try{
			BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Naveli\\Desktop\\portfolio.html"));
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
		String arr[]=new String[line];
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
		String s="",s1="",w="";content=content+" ";
		int d;
		for(int a=0;a<line;a++)
		{
			for(int c=0;c<arr[a].length()-1;c++)
			{
				s="";s1="";
				if(arr[a].charAt(c)=='<' && arr[a].charAt(c+1)!='/' && arr[a].charAt(c+1)!='!')
				{
					s1=arr[a].substring(c+1);
					d=s1.indexOf('>');
					s=arr[a].substring(c+1,d);
					s=s.substring(0,s.indexOf(' '));
				    if(s!="br" || s!="area" || s!="base" || s!="col" || s!="command" || s!="embed" || s!="hr" || s!="img" || s!="input" || s!="keygen" || s!="meta" || s!="link" || s!="menuitem" || s!="param" || s!="source" || s!="track" || s!="wbr")
				    {
				    	w="";
				    for(int e=d;e<content.length();e++)
				    {
				    	if(content.charAt(e)!=' ' || content.charAt(e)!='<' || content.charAt(e)!='>')
				    	{
				    		w=w+content.charAt(e);
				    	}
				    	else{
				    		if(w.equals("/"+s))
				    			break;
				    	}
				    	if(e==content.length()-1)
				    		System.out.println("Closing tag missing in line "+(a+1));
				    }
				    }
		    	}}
	    }
     }
}
