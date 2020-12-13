package usb;

import org.usb4java.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HelloUSB {
    private Context context = null;

    /**
     * 查找 USB 设备
     *
     * @param vendorId
     * @param productId
     * @return
     */
    public Device findDevice(short vendorId, short productId) {
        Device UsbDevice = null;
        context = new Context();
        int result = LibUsb.init(context);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to initialize libusb.:无法初始化libusb", result);

        } else {
            // Read the USB device list:读取USB设备列表
            DeviceList list = new DeviceList();
            result = LibUsb.getDeviceList(context, list);
            //System.out.println("结果：" + result);
            if (result < 0) {
                throw new LibUsbException("Unable to get device list:无法获取设备列表", result);

            } else {
                try {
                    // Iterate over all devices and scan for the right one:遍历所有设备并扫描正确的设备
                    for (Device device : list) {
                        System.out.println("项目日志：" + device);
                        DeviceDescriptor descriptor = new DeviceDescriptor();
                        result = LibUsb.getDeviceDescriptor(device, descriptor);
                        if (result != LibUsb.SUCCESS) {
                            throw new LibUsbException("Unable to read device descriptor:无法读取设备描述符", result);

                        } else {
                            //返回所有USB列表
                            System.out.println("USB 初始化成功");
                            System.out.println("设备：" + device.toString() +
                                    "--"
                                    + "vendorId：" + descriptor.idVendor() +
                                    "--"
                                    + "productId：" + descriptor.idProduct());

                        }

                        // 判断设USB备号相同，则通过device返回设备号
                        /*
                        if (descriptor.idVendor() == vendorId && descriptor.idProduct() == productId) {
                            System.out.println("设备：" + device.toString() +
                                    "--"
                                    + "vendorId：" + descriptor.idVendor() +
                                    "--"
                                    + "productId：" + descriptor.idProduct());
                            UsbDevice=device;
                            //return device;

                        }
                         */

                    }
                } finally {
                    // Ensure the allocated device list is freed:确保分配的设备列表已释放
                    LibUsb.freeDeviceList(list, true);

                }
            }


        }
        //System.out.println("返回USB备号:"+UsbDevice);
        //return UsbDevice; // 返回USB备号
        return null;

    }

    /**
     * 设备句柄:对于真正的 USB 通信，您必须打开一个新的设备句柄，并且必须在与设备通信完成后再次关闭它
     *
     * @param
     */
    public void getDeviceHandle(Device device) {
        DeviceHandle handle = new DeviceHandle();
        int result = LibUsb.open(device, handle);
        if (result != LibUsb.SUCCESS) {
            throw new LibUsbException("Unable to open USB device:无法打开USB设备", result);
        } else {
            try {
                // Use device handle here:在此处使用设备手柄
                System.out.println("Use device handle here:在此处使用设备手柄");

            } finally {
                LibUsb.close(handle);//关闭句柄

            }
        }
        LibUsb.exit(context);//应用程序终止之前，您应该取消初始化 libusb

    }

    /**
     * 控制USB电源
     * power supply
     *
     */
    public void getUSBPowerSupply(){
        try{
            String cmd="sudo uhubctl -a 0 -p 1";
            Process process = Runtime.getRuntime().exec(cmd);//创建实例进程执行命令行代码
            InputStreamReader inputStream=new InputStreamReader(process.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStream);
            String line=null;
            while((line=bufferedReader.readLine()) !=null){
                System.out.println(line + "\r\n");

            }
            bufferedReader.close();
            inputStream.close();

        }catch(Exception e){
            e.printStackTrace();

        }
    }
}
