package org.usfirst.frc.team5915.robot.subsystems;

import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.RGBImage;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 *
 */
public class Camera extends Subsystem {
    
	private static Camera _camera;
	private USBCamera cam;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Camera()
    {
    	try{
    		cam = new USBCamera();
    		CameraServer.getInstance().startAutomaticCapture(cam);
    	}
    	catch(Exception e)
    	{
    		 DriverStation.getInstance().reportError("CAMERA CAN'T CONNECT: " + e.getMessage(), true);
    	}
    }
    
    public static Camera GetInstance()
    {
    	if(_camera == null)
    	{
    		_camera = new Camera();
    	}
    	return _camera;
    }
    
    public boolean isConnected()
    {
    	return CameraServer.getInstance().isAutoCaptureStarted();
    }
    
    public Image getImage()
    {
    	/*Image img = null;
    	
    	cam.getImage(img);*/
    	
    	
    	return null;
    }
}

