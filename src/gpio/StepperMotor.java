package gpio;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

/**
 * 【步进电机】
 * 电机资料：
 * <p>
 * --我接入的是A3A4B3B4端口M2步进电机控制端口
 *                      BCM	wiringPi
 * A3A4B3B4 dir(方向)	24	GPIO_5
 * A3A4B3B4 step(步骤)	18	GPIO_1
 * A3A4B3B4 Dir(目录)	4	GPIO_7
 * A3A4B3B4 mode(模式)	21	GPIO_29
 *                      22	GPIO_3
 *                      27	GPIO_2
 *-----------------------------------
 *                      BCM	wiringPi
 * A3A4B3B4 dir(方向)	13	GPIO_23
 * A3A4B3B4 step(步骤)	19	GPIO_24
 * A3A4B3B4 Dir(目录)	12	GPIO_26
 * A3A4B3B4 mode(模式)	16	GPIO_27
 *                      17	GPIO_0
 *                      20	GPIO_28
 */

public class StepperMotor {
    //GPIO控制器接口。此接口描述了通过GPIO进行的所有操作
    private GpioController gpioController = GpioFactory.getInstance();

    //GPIO控制树莓派的数字针脚
    private GpioPinDigitalOutput GPIO_01 =
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "GPIOController");
    private GpioPinDigitalOutput GPIO_07 =
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_07, "GPIOController");
    private GpioPinDigitalOutput GPIO_29 =
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_29, "GPIOController");
    private GpioPinDigitalOutput GPIO_03 =
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_03, "GPIOController");
    private GpioPinDigitalOutput GPIO_02 =
            gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_02, "GPIOController");

    /*
     * 控制器：开启
     * 设置低电平
     */
    public void getOpenGPIO() {
        //GPIO_05.low();//低电平
        GPIO_01.low();
        GPIO_07.low();
        GPIO_29.low();
        GPIO_03.low();
        GPIO_02.low();

    }

    /*
     * 控制器：关闭
     * 设置高电平
     *
     */
    public void getShutDownGPIO() {
        //GPIO_05.high();//高电平
        GPIO_01.high();
        GPIO_07.high();
        GPIO_29.high();
        GPIO_03.high();
        GPIO_02.high();

    }


}
