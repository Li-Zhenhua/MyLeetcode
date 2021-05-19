package string.medium;

import java.io.CharArrayReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，
 * 返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。

有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。

 
 */

class Solution {
	ArrayList<String> list = null;

    public List<String> restoreIpAddresses(String s) {
    	list = new ArrayList<>();
    	createString(s.toCharArray(), 0, new int[4], 0);
    	return list;
    }

    public void createString(char[] ch, int index, int[] res, int resIndex)
    {
    	if(resIndex == 4 && index == ch.length)
    	{
    		StringBuffer stb = new StringBuffer();
    		for(int i =0; i < 3; i++)
    		{
    			stb.append(res[i]);
    			stb.append(".");
    		}
    		stb.append(res[3]);
    		list.add(stb.toString());
    		return;
    	}
    	if(resIndex < 4 && index == ch.length || resIndex == 4 && index < ch.length)
    		return;
    	
    	int temp = ch[index] - '0';
        res[resIndex] = temp;
    	createString(ch, index + 1, res, resIndex + 1);
    	if(temp != 0)
    	{
    		for(int i = 1; i < 3 && index + i < ch.length; i++)
        	{
        		temp = temp * 10 + (ch[index + i] - '0');
        		if(temp < 256 && temp > 0)
        		{
        			res[resIndex] = temp;
            		createString(ch, index + i + 1, res, resIndex + 1);
        		}
        		else
        			break;
        		
        	}
    	}
    	
    	
    }
}

public class Question93 {
    
}
