package ar.edu.unq.turnero.service

import ar.edu.unq.turnero.modelo.SMS
import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber
import org.springframework.stereotype.Component
import org.springframework.util.MultiValueMap
import java.net.URI

@Component
class SMSService {

    private val ACCOUNT_SID: String? = "AC268d0b045d2b3e270fc1f1ff55f8e84b"
    private val AUTH_TOKEN: String? = "68121216ded1e01170053200ba7314e9"
    private val FROM_NUMBER: String? = "+14634002242"

    fun send(sms: SMS) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN)
        // to number, from: always twilio snd a message
        println(sms.to)
        val message: Message = Message.creator(PhoneNumber(sms.to), PhoneNumber(FROM_NUMBER), sms.message)
            .setStatusCallback(URI.create("http://677add1a.ngrok.io/smscallback"))
            .create()
    }

    fun receive(smscallback: MultiValueMap<String?, String?>?) {}
}