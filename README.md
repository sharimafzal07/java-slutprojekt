**Done by:** Sharim Afzal

# java-slutprojekt
Final project for the Java course - gym membership system

## Project idea
A system for managing a gym's members, with different member types and their rights/discounts.

## Superclass
- Name: Member
- Shared fields: name, memberNumber, age
- Shared methods: `calculateMonthlyFee()`

## Subclasses
1. StudentMember — lower monthly fee
2. PremiumMember — higher fee, access to extra facilities
3. PTMember — has a linked personal trainer, highest fee

## Interface
- Name: Bookable
- Method(s): `book()`
- Implemented by: PremiumMember, PTMember

## Menu
1. Add member
2. Remove member
3. Search member (e.g. by member number or type)
4. Show total monthly revenue (sums `calculateMonthlyFee()` for all members)
5. Exit

## Error scenarios
1. Invalid age when creating a member → IllegalArgumentException in the constructor
2. Invalid input (e.g. text instead of a number) when reading input → NumberFormatException caught with try/catch
