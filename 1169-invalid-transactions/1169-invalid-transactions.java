class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> res = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>(); // same name
        
        // build Map
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            map.computeIfAbsent(t.name, x -> new ArrayList<>()).add(t);
        }
        
        // check each transaction if it is valid
        for (String transaction : transactions) {
            Transaction t = new Transaction(transaction);
            if (!isValid(map.get(t.name), t)) {
                res.add(transaction);
            }
        }
        return res;
    }


    public boolean isValid(List<Transaction> transactions, Transaction t) {
        //if there is only one transaction and the amount is less than 1000
        if (transactions.size() <= 1 && t.amount < 1000) return true;
        
        // check against all other transaction to check if this one is valid
        for (Transaction tran : transactions) {
            if (t.isInValid(tran.city, tran.time)) {
                return false;
            }
        }
        return true;
    }
}


class Transaction {
    String name;
    int time;
    int amount;
    String city;

    public Transaction(String transaction) {
        String[] arr = transaction.split(",");
        this.name = arr[0];
        this.time = Integer.parseInt(arr[1]);
        this.amount = Integer.parseInt(arr[2]);
        this.city = arr[3];
    }

    public boolean isInValid(String city, int time) {
        if (this.amount > 1000) return true;
        if (!this.city.equals(city) && Math.abs(this.time - time) <= 60) return true;
        return false;

    }
}