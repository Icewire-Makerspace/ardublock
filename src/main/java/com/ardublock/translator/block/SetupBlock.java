package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SetupBlock extends TranslatorBlock
{
	public SetupBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		TranslatorBlock translatorBlock = getTranslatorBlockAtSocket(0);
		while (translatorBlock != null)
		{
			String setupCode;
			setupCode = translatorBlock.toCode();
			translator.addSetupAfterCommand(setupCode);
			translatorBlock = translatorBlock.nextTranslatorBlock();
		}
		return "";
	}
}
