# Code KATA

## Kata01 - [Supermarket Pricing](http://codekata.com/kata/com.putoet.kata01-supermarket-pricing/)
This design separates pricing mmodel from the ```Article``` class. The ```PricingScheme``` can have one
```DiscountScheme```. The pricing scheme calculates the total price and subtracts the discount (when a discount scheme
is applicable). In line with a defensive programming approach,  the pricing scheme should validate if the discount
does not exceed the price without discount.
The ```Orders``` class contains a list of orders (```Artice``` and number of units), and is able to calculate the total 
price, by summing the price per article (with discount applied).
By making a distinction between ```NumberPricingScheme``` and ```WeightPricingScheme``` the articles that go by number 
and those that go by weight can be handled slightly differently    

## Kata02 - [Karate Chop](http://codekata.com/kata/kata02-karate-chop/)
Two basic approaches used, one with a loop, and one using recursion (as recursion is just-another-loop), on two 
variants (crwaling through the original array, or creating a copy of the sub-array). The fifth approach felt unnatural,
so I picked the build in Arrays.binarySearch.
The first attempt (LoopingCopyChop) came with most errors to get the sub arrays right. The recursive version, was 
simple and straight forward. The non-copy variant caused again an error on updating ```start``` and ```end``` (again
creating the sub arrays). The build in one, made me fail on an unexpected feature of the build in 
```Arrays.binarySearch``` (it returns index of the search key, if it is contained in the array; otherwise, 
(-(insertion point) - 1))

