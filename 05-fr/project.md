# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

*Aktorzy:* [Sprzedający](#ac1), [Kupujący](#ac2)

*Opis:* Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

*Scenariusz główny:*
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

*Scenariusze alternatywne:* 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC2](#uc2): Przekazanie towaru kupującemu

[Kupujący](#ac2)
* [BR1](#br1): Złożenie oferty
* [BR2](#br2): Rozstrzygnięcie aukcji i przekazanie należności

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

*Aktorzy:* [Sprzedający](#ac1)

*Scenariusz główny:*
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

*Scenariusze alternatywne:* 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Przekazanie towaru kupującemu

*Aktorzy:* [Sprzedający](#ac1), [Kupujący](#ac2)

*Scenariusz główny:*
1. System informuje o zakończeniu aukcji
2. System przekuje dane [kupującego](#ac2)
3. [Sprzedający](#ac1) przekazuje towar [kupującemu](#ac2) w dowolnej formie
4. [Sprzedający](#ac1) potwierdza nadanie towaru
5. System zmienia status przesyłki
6. [Kupujący](#ac2) potwierdza odberanie towaru
7. System informuje o pomyślnym dostarczeniu towaru

*Scenariusze alternatywne:* 

5.A. [Kupujący](#ac2) nie otrzymał przesyłki
* 5.A.1. System informuje o niepowodzeniu dostarczenia przesyłki
* 5.A.2. [Kupujący](#ac2) otrzymuje zwrot środków

---

## Obiekty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji i przekazanie nalezności

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.
[Kupujący](#ac2) dokonuje płatności za towar.

## Macierz CRUDL


| Przypadek użycia                                              | Aukcja | Produkt | Przesyłka |  Płatność |
| -------------------------------------------------             | ------ | ------- | --- | --- |
| [UC1](#uc1): Wystawienia produktu na aukcję                   |    C   |    C    | ... | ... |
| [UC2](#uc2): Przekazanie towaru kupującemu                    |   ...  |    U    | C   |  U  |
| [BR1](#br1): Złożenie oferty                                  |    U   |   ...   | ... | ... |
| [BR2](#br2): Rozstrzygnięcie aukcji i przekazanie należności  |    U   |    D    | ... |  C  |
