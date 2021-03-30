package Lab;
import java.io.*;

public class CheckIDTest
{
	public static void main(String[] args) throws IOException
	{
       	int total=0,n1=0;
       	String idchk = "0123456789ABCDEFGHJKLMNPQRSTUVXYWZIO"; 
		
       	BufferedReader keyin;
	   	keyin = new BufferedReader(
			         new InputStreamReader(System.in));
	   	System.out.print("�п�J�����Ҧr��:");
	   	String id = keyin.readLine();
	  
	   	id=id.toUpperCase();
	   	
       	//�H���h��ܦ��ˬd�r��             
	   	var parttern = "^[A-Z]{1}(1|2){1}\\d{8}$";
		if(!id.matches(parttern)) 
	    {
       		System.err.println("身分證格式錯誤");
         	System.exit(0);
       	}
    
        //���r�r�����[�v��
        n1=idchk.indexOf(id.charAt(0));
        
        total=n1/10+(n1%10)*9; 
  
        //total=total+��L�r�����[�v��
        for(int x=1 ;x<=8; x++)
        {
            total+=Integer.parseInt(id.substring(x,x+1))*(9-x);
        }    
        total+=Integer.parseInt(id.substring(9,10));
		
        if(total % 10 == 0)
            System.out.println("這是正確的身分證");
        else
            System.out.println("這是錯誤的身分證");
//        var str = "123456789";
//        System.out.println(str.charAt(1)+str.charAt(0));
    }
}