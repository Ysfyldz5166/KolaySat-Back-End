package com.satdegerlendir.demo.Card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("api/v1/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @GetMapping("/user/{userId}")
    public List<Card> getCardsByUserId(@PathVariable Long userId) {
        return cardService.getCardsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable Long id) {
        Optional<Card> card = cardService.getCardById(id);
        return card.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Card createCard(@RequestBody Card card) {
        return cardService.saveCard(card);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody Card cardDetails) {
        Optional<Card> optionalCard = cardService.getCardById(id);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.setCardNumber(cardDetails.getCardNumber());
            card.setCardName(cardDetails.getCardName());
            card.setExpiryDate(cardDetails.getExpiryDate());
            card.setCvv(cardDetails.getCvv());
            final Card updatedCard = cardService.saveCard(card);
            return ResponseEntity.ok(updatedCard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        if (cardService.getCardById(id).isPresent()) {
            cardService.deleteCard(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    

}
