package Demo1;

import cn.edu.scau.biubiusuisui.annotation.FXController;
import cn.edu.scau.biubiusuisui.annotation.FXRedirect;
import cn.edu.scau.biubiusuisui.annotation.FXWindow;
import cn.edu.scau.biubiusuisui.entity.FXBaseController;

@FXWindow(title = "窗口2" )
@FXController(path = "fxml/Excetue.fxml")
public class Controller2 extends FXBaseController {

    @FXRedirect
    public String showContent(){
        return "Controller1";
    }
}
