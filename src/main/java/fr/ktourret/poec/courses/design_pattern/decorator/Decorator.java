package fr.ktourret.poec.courses.design_pattern.decorator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class Decorator implements Notifier {

    protected Notifier wrapper;

    @Override
    public void send(String string) {
        if (wrapper != null) {
            wrapper.send(string);
        }
    }

}
