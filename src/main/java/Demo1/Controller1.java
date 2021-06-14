package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;

@FXWindow(title = "窗口1" )
@FXController(path = "fxml/Login.fxml")
public class Controller1 extends FXBaseController {

    @FXRedirect
    public String login(){
        return "Controller2";
    }
}
