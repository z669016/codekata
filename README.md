# Code KATA

## Kata 01 - [Supermarket Pricing](http://codekata.com/kata/com.putoet.kata01-supermarket-pricing/)
This design separates pricing mmodel from the ```Article``` class. The ```PricingScheme``` can have one
```DiscountScheme```. The pricing scheme calculates the total price and subtracts the discount (when a discount scheme
is applicable). In line with a defensive programming approach,  the pricing scheme should validate if the discount
does not exceed the price without discount.
The ```Orders``` class contains a list of orders (```Artice``` and number of units), and is able to calculate the total 
price, by summing the price per article (with discount applied).
By making a distinction between ```NumberPricingScheme``` and ```WeightPricingScheme``` the articles that go by number 
and those that go by weight can be handled slightly differently    
