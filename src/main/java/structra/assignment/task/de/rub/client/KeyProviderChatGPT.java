package structra.assignment.task.de.rub.client;

import structra.assignment.framework.llm.KeyProvider;

public class KeyProviderChatGPT implements KeyProvider{
  private String KEY = "structra-1343abnc-dghpcybpcybub3qgb3vyigfwasbrzxksig5py2ugdhj5ihrobya6kq==";

  public String getApiKey(){
    return this.KEY;
  }
}
