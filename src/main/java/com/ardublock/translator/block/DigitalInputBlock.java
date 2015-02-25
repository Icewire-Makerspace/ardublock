package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class DigitalInputBlock extends TranslatorBlock
{
	
	public DigitalInputBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String number;
		number = translatorBlock.toCode();
		String setupCode = "pinMode( " + number + " , INPUT);";
		translator.addSetupCommand(setupCode);
		String ret = "digitalRead( ";
		ret = ret + number;
		ret = ret + ")";
		return codePrefix + ret + codeSuffix;
	}

}
