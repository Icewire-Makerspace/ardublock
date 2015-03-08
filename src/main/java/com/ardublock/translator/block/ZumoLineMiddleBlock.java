package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class ZumoLineMiddleBlock extends TranslatorBlock
{

	public ZumoLineMiddleBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		translator.addHeaderFile("QTRSensors.h");
		translator.addHeaderFile("ZumoReflectanceSensorArray.h");

		translator.addDefinitionCommand("ZumoReflectanceSensorArray reflectanceSensors;");
		translator.addDefinitionCommand("unsigned int sensors[6];");

		translator.addSetupCommand("reflectanceSensors.init();");

		String ret;
		ret = "(reflectanceSensors.readLine(sensors) > 2000 && reflectanceSensors.readLine(sensors) < 3000)\n";

		return ret;
	}

}
