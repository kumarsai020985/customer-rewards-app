Customer-Rewards Program :

In Memory Details:

Console - URL : http://localhost:8080/h2-ui/
Username : sa
Password : 
DataBase Schema : customer-rewards


Descriiption :  Customer Purchase Transactions Dettails and calculating based on his transaction Amt

End Point : /customer
Method : POST
Request PayLoad :  

{
"customerId" :1,
"customerName:"Sai",
"itemPrices" :[120]  // just taken price only for this assignment instead of taking hard code values

}

Response PayLoad :

Sucess:



Description: Disaplay Customer Transaction Details with Rewards for Each Transaction and Total Rewards for All Transactions

End Point /customer/{customerid}
Method : GET
Request : customerid

Response :

{
    "customerId": 1,
    "customerName": "Sai",
    "trasactionsForm": [
        {
            "transactionId": 1,
            "rewardsPoints": 90,
            "transactionAmt": 120.0
        }
    ],
    "totalRewardsPoints": 90
}
