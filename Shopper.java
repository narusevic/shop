public class Shopper
{
    public static int approveRequest(Request request)
    {
        int clientMoney = request.getClient().getMoney();
        int requestAmount = request.getAmount();
        int wholeRequestPrice = requestAmount * request.getProduct().getPrice();
        int leftInShop = request.getProduct().getAmount();

        if (request.getConfirmation() == null && clientMoney >= wholeRequestPrice && requestAmount <= leftInShop)
        {
            request.setConfirmation(true);
            request.getClient().subtractMoney(request.getAmount() * request.getProduct().getPrice());
            return 0;
        }
        else
        {
            return declineRequest(request);
        }
    }

    public static int declineRequest(Request request)
    {
        if (request.getConfirmation() == null && request.getHasFunds())
        {
            request.setConfirmation(false);
            return 1;
        }

        return 2;
    }
}
