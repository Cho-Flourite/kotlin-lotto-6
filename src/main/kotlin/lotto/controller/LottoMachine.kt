package lotto.controller

import lotto.model.*
import lotto.view.Input
import lotto.view.Output

class LottoMachine {
    fun start(){
        val money = moneyInput()
        val count = Count().calculate(money)
        val userLotto = PurchaseNumberLotto(count)

        Output().printWriteAnswer()
        val answers = Input().write()
        val userInput = UserLottoNumber().convert(answers)


    }
    fun PurchaseNumberLotto(count:Int) :List<List<Int>>{
        Output().printPurchase(count)
        val userLotto: MutableList<List<Int>> = mutableListOf()
        val lotto = Random().lottoGenerator()
        repeat(count) {
            userLotto.add(Lotto(lotto).serve())
            Output().printLottoNumbers(lotto)
        }
        return userLotto
    }
    fun moneyInput():Int{
        Output().printWriteMoney()
        val money = Input().write()
        Money().MoneyFomatValidate(money)
        Money().MoneyRangeValidate(money)
        Money().MoneyChangesValidate(money)
        return money.toInt()
    }
}