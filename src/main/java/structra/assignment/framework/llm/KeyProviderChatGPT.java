package structra.assignment.framework.llm; //package2

import structra.assignment.framework.llm.KeyProvider;

public class KeyProviderChatGPT implements KeyProvider {
  private String key = "structra-1343abnc-dghpcybpcybub3qgb3vyigfwasbrzxksig5py2ugdhj5ihrobya6kq==";

  public String getApiKey(){
    return this.key;
  }
}
