class Solution {
    public String customSortString(String order, String s) {
        
    HashMap<Character,Integer>mp=new HashMap<>();

    String ans="";
 
    for(int i=0;i<s.length();i++){

    if(!mp.containsKey(s.charAt(i))){
        mp.put(s.charAt(i),1);
    }
    else{
        mp.put(s.charAt(i),mp.get(s.charAt(i))+1);
    }

    }

    for(int i=0;i<order.length();i++){

    if(mp.containsKey(order.charAt(i))){

    char[] array = new char[mp.get(order.charAt(i))];
    
    Arrays.fill(array, order.charAt(i));//this function fill the full array with the given value
    
    String temp=new String(array);
    
    ans+=temp;

    mp.remove(order.charAt(i));

    }

    }


    for(char m:mp.keySet()){

    char[] array = new char[mp.get(m)];
    
    Arrays.fill(array, m);
    
    String temp=new String(array);
    
    ans+=temp;

    }

    return ans;

    }
}