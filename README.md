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

## Kata03 - [How Big? How Fast?](http://codekata.com/kata/kata03-how-big-how-fast/)
### How big?
The value 1.000 (roughly 4 x 256) contains about 2 + 8 = 10 bits. 1.000.000 would thus contain 20 (10 + 10) bits,
1.000.000.000 would require 30 bits and 1.000.000.000.000 would require 40 bits. 8.000.000.000.000 would require 43 
(3+ 40) bits. Remember, adding one bit iss equivalent with multiplying by 2.

Storing names (45 bytes), addresses (45 bytes), and phone numbers (10 bytes) of 20.000 residents would take roughly 
200.000 bytes (200Kb).

1.000.000 in a binary tree, is roughly 20 layers, 500.000 nodes, and 500.000 leaves. Each node needs 2 pointers 
(left and right) of 32 bits and an integer of 32 bits (so a node is 12 bytes) and a leave only contains an integer
of 4 bytes. to store the lot, you need 500.000 x 12 + 500.000 x 4 = 16.000.000 bytes (16Mb roughly). 

### How fast?
A 56k baud modem transfers 56 * 1024 bits per second. Assuming 10% overhead, it will take 
(1.200 x 8 x bytes per page) / (90% x 56.000 x 1.024) seconds.

Speed of binary search is not linear. So for simplicity, lets say that a growth of factor 10 (so times 10)
means an increase of search time with 33%. 
| size       | search time |
| ---------- | ----------- |
| 10.000     | 4.5 sec     |
| 100.000    | 6 sec       |
| 1.000.000  | 6.75 sec    |
| 10.000.000 | 7 sec       |

Hacking a 16 character password with 96 options for each character requires 96^16 ms which is like forever. Unless the 
hash can be calculated much, much, much (e.g. many in parallel) this is not feasible.

## Kata04 - [Data Munging](http://codekata.com/kata/kata04-data-munging/)
So many possible solutions ... stream operations are ideal for these matters, so part one is to transform the file
content (```List<SString>```) into a data structure. Parsing the line with a regular expression proofed a bit nasty
so, I decided to just take substrings and transform those into values (```int```, ```double```, ```String```, and 
```OptionalInt```). I moved this task into a static function of the data class, and added a function that would take a 
list of lines, to transform that into a list of data objects. The same approach was used for part 2, but I moved the 
substring transform methods into a utility class.

In order to make more methods generic, I moved the function to create a list of lines onto a list of data objects into 
the parser as well. The ```Parser``` would be created with passing a factory method (from String line to data object) to
the constructor.

Of course the parsing of the lines could be made more generic, but I don't feel that would make the solution simpler
or more reusable.