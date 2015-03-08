
package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ZumoFindLineBlock extends TranslatorBlock
{

	public ZumoFindLineBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("QTRSensors.h");
		translator.addHeaderFile("ZumoReflectanceSensorArray.h");
		translator.addHeaderFile("ZumoMotors.h");

		translator.addDefinitionCommand("ZumoReflectanceSensorArray reflectanceSensors;");
		translator.addDefinitionCommand("ZumoMotors motors;");

		translator.addSetupCommand("reflectanceSensors.init();");

		String ret;
		ret = "int i;\n";
		ret += "for(i = 0; i < 80; i++) {\n";
		ret += "if ((i > 10 && i <= 30) || (i > 50 && i <= 70))\n";
		ret += "motors.setSpeeds(-200, 200);\n";
		ret += "else\n";
		ret += "motors.setSpeeds(200, -200);\n";
		ret += "reflectanceSensors.calibrate();\n";
		ret += "delay(20);\n";
		ret += "}\n";
		ret += "motors.setSpeeds(0,0);\n";

		return ret;
	}

}
