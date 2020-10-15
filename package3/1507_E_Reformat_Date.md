
This is my solution :

```Java

class Solution {
    public String reformatDate(String date) {
        StringBuilder res = new StringBuilder();
        String[] dates = date.split(" ");
        res.append(dates[2]).append("-");
        
        Map<String,String> map = new HashMap<>();
        map.put("Jan","01");
        map.put("Feb","02");
        map.put("Mar","03");
        map.put("Apr","04");
        map.put("May","05");
        map.put("Jun","06");
        map.put("Jul","07");
        map.put("Aug","08");
        map.put("Sep","09");
        map.put("Oct","10");
        map.put("Nov","11");
        map.put("Dec","12");
        
        res.append(map.get(dates[1])).append("-");
        
        // for days, it doesnot need to be so complex
        // we can easily do :
        // res.append(dates[0].length() == 3 ? ("0" + dates[0].substring(0, 1)) : dates[0].substring(0, 2));
        int day = 0;
        for(char ch:dates[0].toCharArray()) {
            if(ch>='0' && ch<='9')
                day = day*10 + (ch-'0');
        }
        if(day<10)
            res.append("0");
        res.append(day);
        return res.toString();
        
    }
}

```

Another Java solution here : more tricks :

```Java

class Solution {
    public String reformatDate(String date) {
        String[] d = date.split(" ");
        int dd = Integer.parseInt(d[0].substring(0, d[0].length() - 2));
        String[] month = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> monthList = Arrays.asList(month);
        int mm = monthList.indexOf(d[1]) + 1;
        return d[2] + "-" + String.format("%02d", mm) + "-" + String.format("%02d", dd);
    }
}

```

So this will be the Python Solution :

```Python

def reformatDate(self, date: str) -> str:
        M = {
            "Jan": "01", 
            "Feb": "02", 
            "Mar": "03", 
            "Apr": "04", 
            "May": "05", 
            "Jun": "06", 
            "Jul": "07", 
            "Aug": "08", 
            "Sep": "09", 
            "Oct": "10", 
            "Nov": "11", 
            "Dec": "12"
        }
        D = date.split(' ')
        return '{}-{}-{:0>2}'.format(D[2], M[D[1]], D[0][:-2])

```