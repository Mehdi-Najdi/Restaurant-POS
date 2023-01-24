using System.Collections;
using System.Collections.Generic;
using UnityEngine.UI;
using UnityEngine;
using TMPro;

public class timer : MonoBehaviour
{
  float currentTime = 0f;
  float startingTime = 60f;

  public TMP_Text countDownText;
  public GameObject player;
  private AudioSource source;

  void Start()
  {
      currentTime = startingTime;
      source = GetComponent<AudioSource>();
  }

  void Update()
  {
    if (currentTime == 10)
    {
      source.Play();

    }
    if (currentTime > 0)
    {
      currentTime -= 1 * Time.deltaTime;
      countDownText.text = currentTime.ToString("#."); 
    }
    else{
        currentTime = 0.00f;
        countDownText.text = "FIN";
        player.SetActive(false);
      }
    
  }
}
