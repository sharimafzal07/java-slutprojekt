**Utförs av:** Sharim Afzal

# java-slutprojekt
Slutprojekt för Java-kursen - gymmedlemssystem
## Projektidé
Ett system för att hantera ett gyms medlemmar, med olika medlemstyper och deras rättigheter/rabatter.
## Superklass
- Namn: Medlem
- Gemensamma fält: namn, medlemsnummer, ålder
- Gemensamma metoder: beräknaMånadsavgift()
## Subklasser
1. StudentMedlem — lägre månadsavgift
2. PremiumMedlem — högre avgift, tillgång till extra faciliteter
3. PTMedlem — har en kopplad personlig tränare, högst avgift
## Interface
- Namn: Bokningsbar
- Metod(er): boka()
- Implementeras av: PremiumMedlem, PTMedlem
## Meny
1. Lägg till medlem
2. Ta bort medlem
3. Sök medlem (t.ex. på medlemsnummer eller typ)
4. Visa total månadsintäkt (summerar beräknaMånadsavgift() för alla medlemmar)
5. Avsluta
## Felscenarion
1. Ogiltig ålder vid skapande av medlem → IllegalArgumentException i konstruktorn
2. Ogiltig inmatning (t.ex. text istället för siffra) vid inläsning → NumberFormatException fångas med try/catch
