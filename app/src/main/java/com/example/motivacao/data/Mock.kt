package com.example.motivacao.data

import com.example.motivacao.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description: String, val category: Int)

class Mock {
    private val listPhrases: List<Phrase> = listOf(
        Phrase("Não sabendo que era impossível, foi lá e fez.", MotivationConstants.Filter.HAPPY),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", MotivationConstants.Filter.HAPPY),
        Phrase("Quando está mais escuro, vemos mais estrelas!", MotivationConstants.Filter.HAPPY),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", MotivationConstants.Filter.HAPPY),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", MotivationConstants.Filter.HAPPY),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", MotivationConstants.Filter.HAPPY),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", MotivationConstants.Filter.SUNNY),
        Phrase("Você perde todas as chances que você não aproveita.", MotivationConstants.Filter.SUNNY),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", MotivationConstants.Filter.SUNNY),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", MotivationConstants.Filter.SUNNY),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", MotivationConstants.Filter.SUNNY),
        Phrase("Se você acredita, faz toda a diferença.", MotivationConstants.Filter.SUNNY),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", MotivationConstants.Filter.SUNNY)
    )

    // Obtém frase aleatória de acordo com o filtro
    fun getPhrase(value: Int): String {
        val filtered = listPhrases.filter { (it.category == value || value == MotivationConstants.Filter.ALL) }

        // Número aleatório de 0 ao tamanho da lista retornada do filtro
        val rand = Random.nextInt(filtered.size)

        // Retorna string
        return filtered[rand].description
    }
}